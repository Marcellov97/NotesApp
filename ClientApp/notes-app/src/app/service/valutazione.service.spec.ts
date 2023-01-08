import { TestBed } from '@angular/core/testing';

import { ValutazioneService } from './valutazione.service';

describe('ValutazioneService', () => {
  let service: ValutazioneService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ValutazioneService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
