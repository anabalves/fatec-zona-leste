import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TaskService } from 'src/app/task.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  User: any = ['Super Admin', 'Author', 'Reader'];

  constructor(
    private taskService: TaskService, private router: Router
  ) { }

  ngOnInit(): void {
  }

}