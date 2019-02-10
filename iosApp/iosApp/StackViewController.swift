//
//  StackViewController.swift
//  iosApp
//
//  Created by Tomasz Babiuk on 08.02.2019.
//

import UIKit
import main

class StackViewController: UINavigationController {
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let router = StoryboardViewRouter()
        let navigationService = iOSNavigationService(navigationController: self, viewRouter: router)
        let bootstrap = SampleBootstrap()
        bootstrap.navigationService = navigationService
        bootstrap.start()
    }
}
