//
//  TermsViewController.swift
//  iosApp
//
//  Created by Tomasz Babiuk on 08.02.2019.
//

import UIKit
import main

class iOSNavigationService : NSObject, NavigationService {
    
    func showViewModel(factory: KonakisViewModelFactory) {
        
    }
    
    func finish() {
        exit(0)
    }
}

class TermsViewController: UIViewController {

    var model: TermsViewModel?

    init(viewModel: TermsViewModel) {
        self.model = viewModel
        super.init(nibName: nil, bundle: nil)
    }
    
    required init?(coder: NSCoder) {
        self.model = nil
        super.init(coder: coder)
    }

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
    
    override func viewDidLoad() {
        super.viewDidLoad()
        model = createModel()
    }
    
    func createModel() -> TermsViewModel {
        let navService = iOSNavigationService()
        let model = TermsViewModel(navigationService: navService)
        return model
    }
}

