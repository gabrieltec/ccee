import { ComponentFixture, TestBed } from '@angular/core/testing';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { AgenteComponent } from './agente.component';
import { AgenteService } from 'src/app/core/services/agente.service';

describe('AgenteComponent', () => {
  let component: AgenteComponent;
  let fixture: ComponentFixture<AgenteComponent>;

  beforeEach(() => {
    const countryServiceStub = () => ({
      getAgentes: () => ({ subscribe: (f: (arg0: {}) => any) => f({}) }),
    });
    TestBed.configureTestingModule({
      schemas: [NO_ERRORS_SCHEMA],
      declarations: [AgenteComponent],
      providers: [{ provide: AgenteService, useFactory: countryServiceStub }],
    });
    fixture = TestBed.createComponent(AgenteComponent);
    component = fixture.componentInstance;
  });

  it('can load instance', () => {
    expect(component).toBeTruthy();
  });

  it(`projetos has default value`, () => {
    expect(component.agentes).toEqual([]);
  });

  describe('ngOnInit', () => {
    it('makes expected calls', () => {
      const agenteServiceStub: AgenteService =
        fixture.debugElement.injector.get(AgenteService);
      spyOn(agenteServiceStub, 'getAgentes').and.callThrough();
      component.ngOnInit();
      expect(agenteServiceStub.getAgentes).toHaveBeenCalled();
    });
  });
});
