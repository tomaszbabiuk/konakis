//
//  KonaxBinding.swift
//  iosApp
//
//  Created by Tomasz Babiuk on 18.02.2019.
//

import UIKit
import main

protocol KnxBond {
    func bind()
    func unbind()
}

class BaseKnxBond<T> : NSObject, BindingObserver, KnxBond {
    
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

class UITextFieldKnxBond : BaseKnxBond<UITextField> {
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

class UILabelKnxBond : BaseKnxBond<UILabel> {
    override func updateControlIfNeeded(_ newValue: String?) {
        control.text = newValue
    }
}

extension UITextField {
    func knxBind(to: ObservableString, _ bonds: KnxBondsBag) {
        let bond = UITextFieldKnxBond(control: self, field: to)
        bonds.addBond(bond)
    }
}

extension UILabel {
    func knxBind(to: ObservableString, _ bonds: KnxBondsBag) {
        let bond = UILabelKnxBond(control: self, field: to)
        bonds.addBond(bond)
    }
}

class KnxBondsBag {
    
    var bonds: [KnxBond] = []
    
    func addBond(_ bond: KnxBond) {
        bonds.append(bond)
    }
    
    func bindAll() {
        bonds.forEach { x in x.bind() }
    }
    
    func unbindAll() {
        bonds.forEach { x in x.unbind() }
    }
}
