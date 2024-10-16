import { TestBed } from '@angular/core/testing';
import { CanActivateFn } from '@angular/router';

import { oeuvreGuard } from './oeuvre.guard';

describe('oeuvreGuard', () => {
  const executeGuard: CanActivateFn = (...guardParameters) => 
      TestBed.runInInjectionContext(() => oeuvreGuard(...guardParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});
