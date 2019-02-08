//
//  View2ViewController.swift
//  iosApp
//
//  Created by Tomasz Babiuk on 08.02.2019.
//

import UIKit

class View2ViewController : UIViewController {
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    @IBAction func onButtonClick(_ sender: Any) {
        navigationController?.popViewController(animated: true)
    }
}
