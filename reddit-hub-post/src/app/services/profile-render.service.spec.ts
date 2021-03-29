import { TestBed } from '@angular/core/testing';

import { ProfileRenderService } from './profile-render.service';

describe('ProfileRenderService', () => {
  let service: ProfileRenderService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProfileRenderService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
