public enum Vote implements BulletinVote{
  oui('o'),
  non('n'),
  nul('u'),
  blanc('b');

  private final char code ;

  public Vote(char code){
    this.code=code;
  }
}
