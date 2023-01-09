import { TestBed } from '@angular/core/testing';

import { SegnalazioneService } from './segnalazione.service';

describe('SegnalazioneService', () => {
  let service: SegnalazioneService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SegnalazioneService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
