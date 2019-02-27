//
//  KonaxNavigation.swift
//  iosApp
//
//  Created by Tomasz Babiuk on 09.02.2019.
//

import UIKit
import main

protocol ViewRouter {
    func routeToView(factory: KnxViewModelFactory) throws -> UIViewController
}

class KnxViewController<T : KnxViewModel> : UIViewController {
    var model: T!
    
    private let bondsBag = KnxBondsBag()
    
    override func viewWillAppear(_ animated: Bool) {
        bondsBag.bindAll()
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        bondsBag.unbindAll()
    }
    
    func bindViewModel(_ model: T) {
        self.model = model
    }
    
    override func viewDidLoad() {
        createBindings(bonds: bondsBag)
    }
    
    func createBindings(bonds: KnxBondsBag) {
    }
}


class RoutingException : Error {
}

class StoryboardViewRouter: ViewRouter {
    
    func bind<C:KnxViewController<M>, M:KnxViewModel>(controller: C, factory: KnxViewModelFactory) -> KnxViewController<M> {
        let model = factory.create() as! M
        controller.bindViewModel(model)
        
        return controller
    }
    
    func routeToView(factory: KnxViewModelFactory) throws -> UIViewController {
        if factory is TermsViewModelFactory {
            let viewController = loadFromStoryboard("Terms", "Terms") as! TermsViewController
            return bind(controller: viewController, factory: factory)
        }
        
        if factory is DemoViewModelFactory {
            let viewController = loadFromStoryboard("Demo", "Demo") as! DemoViewController
            return bind(controller: viewController, factory: factory)
        }
        
        if (factory is SimpleBindingViewModelFactory) {
            let viewController = loadFromStoryboard("SimpleBinding", "SimpleBinding") as! SimpleBindingViewController
            
            return bind(controller: viewController, factory: factory)
        }
        
        throw RoutingException()
    }
    
    func loadFromStoryboard(_ storyboardIdentifier: String, _ viewIdentifier: String) -> UIViewController {
        let storyboard = UIStoryboard(name: storyboardIdentifier, bundle: nil)
        return storyboard.instantiateViewController(withIdentifier: viewIdentifier)
    }
}

class iOSNavigationService : NSObject, KnxNavigationService {
    
    let navigationController: UINavigationController
    let viewRouter: ViewRouter
    
    init(navigationController: UINavigationController, viewRouter: ViewRouter) {
        self.navigationController = navigationController
        self.viewRouter = viewRouter
    }
    
    func showViewModel(factory: KnxViewModelFactory) {
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
