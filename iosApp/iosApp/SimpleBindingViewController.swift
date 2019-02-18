//
//  SimpleBindingViewController.swift
//  iosApp
//
//  Created by Tomasz Babiuk on 10.02.2019.
//
import UIKit
import main

class SimpleBindingViewController : KonakisViewController<SimpleBindingViewModel> {
    
    @IBOutlet weak var txtFirst: UITextField!
    
    @IBOutlet weak var txtLast: UITextField!
    
    @IBOutlet weak var lblSummary: UILabel!
    
    @IBAction func onShuffleClick(_ sender: UIButton) {
        model.shuffle()
    }
    
    override func createBindings(bonds: KonakisBondsBag) {
        txtFirst.konakisBind(to: model.firstName, bonds)
        txtLast.konakisBind(to: model.lastName, bonds)
        lblSummary.konakisBind(to: model.fullName, bonds)
    }
}
