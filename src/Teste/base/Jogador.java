package Teste.base;

public class Jogador {
    private String nome;
    private String id;
    private int kills;

    @Override
    public String toString(){
        return nome;
    }

    public Jogador(String nome,String id,int kills){
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
