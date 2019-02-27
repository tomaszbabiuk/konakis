//
//  SimpleBindingViewController.swift
//  iosApp
//
//  Created by Tomasz Babiuk on 10.02.2019.
//
import UIKit
import main

class SimpleBindingViewController : KnxViewController<SimpleBindingViewModel> {
    
    @IBOutlet weak var txtFirst: UITextField!
    
    @IBOutlet weak var txtLast: UITextField!
    
    @IBOutlet weak var lblSummary: UILabel!
    
    @IBAction func onShuffleClick(_ sender: UIButton) {
        model.shuffle()
    }
    
    override func createBindings(bonds: KnxBondsBag) {
        txtFirst.knxBind(to: model.firstName, bonds)
        txtLast.knxBind(to: model.lastName, bonds)
        lblSummary.knxBind(to: model.fullName, bonds)
    }
}
