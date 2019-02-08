//
//  StackViewController.swift
//  iosApp
//
//  Created by Tomasz Babiuk on 08.02.2019.
//

import UIKit

class StackViewController: UINavigationController {
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let storyboard = UIStoryboard(name: "Stack", bundle: nil)
        let firstViewController = storyboard.instantiateViewController(withIdentifier: "first")
        pushViewController(firstViewController, animated: true)

        let secondViewController = storyboard.instantiateViewController(withIdentifier: "second")
        pushViewController(secondViewController, animated: true)
    }
}
