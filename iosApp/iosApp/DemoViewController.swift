//
//  View1ViewController.swift
//  iosApp
//
//  Created by Tomasz Babiuk on 08.02.2019.
//

import UIKit
import main

class DemoViewController : KonakisViewController<DemoViewModel> {
    
    @IBAction func onSimpleBindingClick(_ sender: Any) {
        model.goToSimpleBinding()
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
}
