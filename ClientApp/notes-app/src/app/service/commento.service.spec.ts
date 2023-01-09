import { TestBed } from '@angular/core/testing';

import { CommentoService } from './commento.service';

describe('CommentoService', () => {
  let service: CommentoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CommentoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
