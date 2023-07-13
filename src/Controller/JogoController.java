package Controller;

import gui.PanelJogo;
import java.util.Vector;
import javax.swing.JOptionPane;

public class JogoController 
{
    
    private int erros;
    private int acertos;
    private String palavra;
    private Vector<String> letras;
    private PanelJogo panel;

    public JogoController(PanelJogo panel, String palavra) 
    {
        this.erros = 0;
        this.acertos = 0;
        this.panel = panel;
        this.palavra = palavra;
        this.letras = new Vector<>();
    }
    
    public int getErros()
    {
        this.erros++;
        return this.erros;
    }
    
    public String contaAcertos(String letra)
    {
        
        String[] letras = this.palavra.split("");
        if(!this.letras.contains(letra))
        {
            for(int i = 0; i < letras.length; i++)
            {
                if(letras[i].equals(letra))
                {
                    acertos++;
                    
                    if(!this.letras.contains(letra))
                    {
                        this.letras.add(letra);
                    }
                }
            }
            
        }else {
            JOptionPane.showMessageDialog(this.panel, "Essa letra ja foi acertada!");
        }
        
        String palavra = "";
        for(int i = 0; i < letras.length; i++)
        {
            boolean b = false;
            for(int f = 0; f < this.letras.size(); f++)
            {
                if(letras[i].equals(this.letras.get(f)))
                {
                    palavra += this.letras.get(f).toUpperCase();
                    b = true;
                }
            }
            if(b)
            {
                palavra += "  ";
            }else {
                palavra += "__  ";
            }
        }
        
        return palavra;
    }
    
    public String contaLetras(String palavra)
    {
        String tamanho = "";
        
        for(int i = 0; i < palavra.length(); i++)
        {
            tamanho += "__";
            
            if(i < (palavra.length()-1))
            {
                tamanho += " ";
            }
        }
        
        return tamanho;
        
    }
    
    public boolean confereLetra(String palavra, String letra)
    {
        return(palavra.contains(letra));
    }
    
    public boolean verificaErros()
    {
        return this.erros <= 5;
    }
    
    public boolean verificaAcertos()
    {
        return this.acertos>=this.palavra.length();
    }
}
