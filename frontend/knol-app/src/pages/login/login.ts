import { Component } from "@angular/core";
import { NavController } from "ionic-angular";
import { LoginForm } from "../../models/login-form";
import {LoginService} from "./login.service";
import { AlertController } from "ionic-angular";
import {SharedService} from "../../services/shared.service";
import {HomePage} from "../home/home";

@Component({
  selector: "page-login",
  templateUrl: "login.html",
  providers: [LoginService]
})
export class LoginPage {
  loginFormObj: LoginForm = new LoginForm();

  constructor(public navCtrl: NavController,
              private loginService: LoginService,
              private sharedService: SharedService,
              private alertController: AlertController) {}

  submit() {
    this.loginService.login(this.loginFormObj).subscribe( (data: any) => {
      console.log(data);
      localStorage.setItem("user", JSON.stringify(data.data.user));
      localStorage.setItem("accessToken", JSON.stringify(data.data.accessToken));
      this.sharedService.isLoggedIn = true;
      this.alertController.create({title : "Successfully Logged in", message: ""});
      this.navCtrl.push(HomePage);
    }, (err: any) => {
      console.log(err);
      this.alertController.create({title : "Invalid credentials", message: ""});
    });
  }

}
