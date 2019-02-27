//
//  TermsViewController.swift
//  iosApp
//
//  Created by Tomasz Babiuk on 08.02.2019.
//

import UIKit
import main

class TermsViewController: KnxViewController<TermsViewModel> {
    @IBOutlet weak var lblAccept: UIButton!
    @IBOutlet weak var lblReject: UIButton!
    
    @IBAction func onRejectClicked(_ sender: Any) {
        model?.onReject()
    }
    
    @IBAction func onAcceptClicked(_ sender: Any) {
        model?.onAccept()
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
}

