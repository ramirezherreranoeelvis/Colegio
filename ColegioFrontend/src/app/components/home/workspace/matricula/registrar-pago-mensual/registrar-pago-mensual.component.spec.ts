import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrarPagoMensualComponent } from './registrar-pago-mensual.component';

describe('RegistrarPagoMensualComponent', () => {
  let component: RegistrarPagoMensualComponent;
  let fixture: ComponentFixture<RegistrarPagoMensualComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegistrarPagoMensualComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RegistrarPagoMensualComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
