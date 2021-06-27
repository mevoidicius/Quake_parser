package Teste.base;

public class Jogador {
    private String nome;
    private String id;
    private int kills;

    @Override
    public String toString(){
        return this.nome+" :"+kills;
    }

    @Override
    public boolean equals(Object obj) {
        final Jogador other = (Jogador) obj;
        return (this.id.equals(other.id));
    }

    public Jogador(String nome,String id){
        this.nome=nome;
        this.id=id;
        this.kills=0;
    }

    public void setKills(int kills){
        this.kills=kills;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    public int getKills() {
        return kills;
    }









}
