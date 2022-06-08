import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultarLivroComponent } from './consultar-livro.component';

describe('ConsultarLivroComponent', () => {
  let component: ConsultarLivroComponent;
  let fixture: ComponentFixture<ConsultarLivroComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsultarLivroComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultarLivroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
