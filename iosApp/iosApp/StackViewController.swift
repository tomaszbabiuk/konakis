//
//  StackViewController.swift
//  iosApp
//
//  Created by Tomasz Babiuk on 08.02.2019.
//

import UIKit
import main

protocol ViewRouter {
    func routeToView(factory: KonakisViewModelFactory) throws -> UIViewController
}

class RoutingException : Error {
}

class StoryboardViewRouter: ViewRouter {
    
    let storyboard: UIStoryboard
    
    init(storyboardName:String) {
        storyboard = UIStoryboard(name: storyboardName, bundle: nil)
    }
    
    func routeToView(factory: KonakisViewModelFactory) throws -> UIViewController {
        if factory is TermsViewModelFactory {
            return storyboard.instantiateViewController(withIdentifier: "Terms")
        }
        
        if factory is DemoViewModelFactory {
            return storyboard.instantiateViewController(withIdentifier: "Demo")
        }
        
        throw RoutingException()
    }
}

class iOSNavigationService : NSObject, NavigationService {
    
    let navigationController: UINavigationController
    let viewRouter: ViewRouter
    
    init(navigationController: UINavigationController, viewRouter: ViewRouter) {
        self.navigationController = navigationController
        self.viewRouter = viewRouter
    }
    
    func showViewModel(factory: KonakisViewModelFactory) {
        do {
            let viewController = try viewRouter.routeToView(factory: factory)
            navigationController.pushViewController(viewController, animated: true)
        } catch {
            print("dupa dupa")
        }
    }
    
    func finish() {
        exit(0)
    }
}

class StackViewController: UINavigationController {
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let router = StoryboardViewRouter(storyboardName: "Stack")
        let navigationService = iOSNavigationService(navigationController: self, viewRouter: router)
        let bootstrap = SampleBootstrap()
        bootstrap.navigationService = navigationService
        bootstrap.start()
    }
}
