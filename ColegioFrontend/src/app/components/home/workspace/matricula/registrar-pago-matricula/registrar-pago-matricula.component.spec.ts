import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrarPagoMatriculaComponent } from './registrar-pago-matricula.component';

describe('RegistrarPagoMatriculaComponent', () => {
  let component: RegistrarPagoMatriculaComponent;
  let fixture: ComponentFixture<RegistrarPagoMatriculaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegistrarPagoMatriculaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RegistrarPagoMatriculaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
