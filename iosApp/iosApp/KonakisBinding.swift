//
//  KonakisBinding.swift
//  iosApp
//
//  Created by Tomasz Babiuk on 18.02.2019.
//

import UIKit
import main

protocol KonakisBond {
    func bind()
    func unbind()
}

class BaseKonakisBond<T> : NSObject, BindingObserver, KonakisBond {
    
    func set(value: Any?) {
        if let valueAsString = value as? String? {
            updateControlIfNeeded(valueAsString)
        }
    }
    
    var field: ObservableString
    var control : T
    
    required init(control: T, field: ObservableString) {
        self.control = control
        self.field = field
        super.init()
    }
    
    func bind() {
        updateControlIfNeeded(field.get())
        field.addObserver(observer: self)
    }
    
    func unbind() {
        field.removeObserver(observer: self)
    }
    
    func updateControlIfNeeded(_ newValue: String?) {
    }
}

class UITextFieldKonakisBond : BaseKonakisBond<UITextField> {
    @objc func textFieldDidChange(textField: UITextField) {
        field.set(value_: textField.text)
    }
    
    override func bind() {
        super.bind()
        control.addTarget(self, action: #selector(textFieldDidChange(textField:)), for: .editingChanged)
    }
    
    override func unbind() {
        super.unbind()
        control.removeTarget(self, action: #selector(textFieldDidChange(textField:)), for: .editingChanged)
    }
    
    override func updateControlIfNeeded(_ newValue: String?) {
        control.text = newValue
    }
}

class UILabelKonakisBond : BaseKonakisBond<UILabel> {
    override func updateControlIfNeeded(_ newValue: String?) {
        control.text = newValue
    }
}

extension UITextField {
    func konakisBind(to: ObservableString, _ bonds: KonakisBondsBag) {
        let bond = UITextFieldKonakisBond(control: self, field: to)
        bonds.addBond(bond)
    }
}

extension UILabel {
    func konakisBind(to: ObservableString, _ bonds: KonakisBondsBag) {
        let bond = UILabelKonakisBond(control: self, field: to)
        bonds.addBond(bond)
    }
}

class KonakisBondsBag {
    
    var bonds: [KonakisBond] = []
    
    func addBond(_ bond: KonakisBond) {
        bonds.append(bond)
    }
    
    func bindAll() {
        bonds.forEach { x in x.bind() }
    }
    
    func unbindAll() {
        bonds.forEach { x in x.unbind() }
    }
}
