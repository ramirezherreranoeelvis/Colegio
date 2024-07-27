import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrarMatriculaComponent } from './registrar-matricula.component';

describe('RegistrarMatriculaComponent', () => {
  let component: RegistrarMatriculaComponent;
  let fixture: ComponentFixture<RegistrarMatriculaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegistrarMatriculaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RegistrarMatriculaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
