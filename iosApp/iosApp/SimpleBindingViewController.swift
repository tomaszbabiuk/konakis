//
//  SimpleBindingViewController.swift
//  iosApp
//
//  Created by Tomasz Babiuk on 10.02.2019.
//
import UIKit
import main

class SimpleBindingViewController : KonakisViewController<SimpleBindingViewModel> {
    @IBAction func onFirstNameChanged(_ sender: UITextField) {
        model?.firstName.set(value: sender.text)
    }
    
    @IBAction func onLastNameChanged(_ sender: UITextField) {
        model?.lastName.set(value: sender.text)
    }
    
    @IBAction func onShuffleClick(_ sender: UIButton) {
        model?.shuffle()
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    override func bindViewModel(_ model: SimpleBindingViewModel) {
        super.bindViewModel(model)
        
        model.firstName.setObserver(observer: {a in
            print(a)
            return KotlinUnit()
        })
    }
}
