import { Component, OnInit } from '@angular/core';
import { TaskService } from 'src/app/task.service';

@Component({
  selector: 'app-relatorios',
  templateUrl: './relatorios.component.html',
  styleUrls: ['./relatorios.component.css']
})
export class RelatoriosComponent implements OnInit {

  emprestimos = [];

  constructor(private taskService: TaskService) { }

  ngOnInit(): void {
    this.getRelatorioEmprestimos();
  }

  getRelatorioEmprestimos() {
    this.taskService.relatorioEmprestimos().subscribe((response: any) => {
      this.emprestimos = response;
      console.log(this.emprestimos)
    });
  }

}
