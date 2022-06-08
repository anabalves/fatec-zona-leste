import { Component, OnInit } from '@angular/core';
import { TaskService } from 'src/app/task.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  constructor(private taskService: TaskService) { }


  ngOnInit(): void {
  }
 //email: string, senha: string
  login() {
    this.taskService.login('arthur.viveiros@fatec.sp.gov.br','arthur123').subscribe((response: any) => {
      console.log(response);
    });
  }
}
