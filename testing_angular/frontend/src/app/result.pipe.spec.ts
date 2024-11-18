import { ResultPipe } from './result.pipe';

describe('ResultPipe', () => {
  const pipe = new ResultPipe()
  
  it(`transform('0.111', 2) toBe 0.11`, () => {
    expect(pipe.transform('0.111', 2)).toBe(0.11)
  })

  it(`transform('0.99', 1) toBe 1`, () => {
    expect(pipe.transform('0.99', 1)).toBe(1)
  })
});
