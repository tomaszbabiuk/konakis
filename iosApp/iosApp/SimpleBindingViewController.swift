//
//  SimpleBindingViewController.swift
//  iosApp
//
//  Created by Tomasz Babiuk on 10.02.2019.
//
import UIKit
import main

//extension ObservableString {
//    var boundTextView: UITextView?
//
//    func bindTextView(_ textView : UITextView) {
//
//    }
//}

extension ObservableString {
    
    @objc func update(_ sender: UITextField) {
        sender.text = get()
    }
    
    func bind(toUITextField textField: UITextField) {
        textField.addTarget(self, action: #selector(update), for: .editingDidEnd)
        setObserver(observer: {a in
                textField.text = a
                return KotlinUnit()
            })
        update(textField)
    }
}

class SimpleBindingViewController : KonakisViewController<SimpleBindingViewModel> {
    
    @IBOutlet weak var txtFirst: UITextField!
    
    @IBOutlet weak var txtLast: UITextField!
    
    @IBAction func onShuffleClick(_ sender: UIButton) {
        model?.shuffle()
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        model?.firstName.bind(toUITextField: txtFirst)
        model?.lastName.bind(toUITextField: txtLast)
    }
}
