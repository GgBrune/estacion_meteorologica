import java.util.ArrayList; 

/**
 * Registros de temperaturas diarios de una estacion meteorológica
 * Autor: Aguirre Nazareno
 */
public class MedicionesTemperaturas
{
    /**
     * Contiene las mediciones de temperaturas.
     */
    private ArrayList<Integer> registros;
    
    /**
     * Dia del registro
     */
    private int dia;
    
    /**
     * Mes del registro
     */
    private int mes;
    
    /**
     * Constructor de la clase. Inicializa dia y mes con los parámetros respectivos,
     * y la lista de registros se inicializa vacía (sin mediciones).
     * Precondición: 
     *  - dia debe ser un día válido (entre 1 y 31)
     *  - mes debe ser un mes válido (entre 1 y 12)
     */
    public MedicionesTemperaturas(int dia, int mes)
    {
        this.dia = dia;
        this.mes = mes;
        this.registros = new ArrayList<Integer>();
        assert repOk();
    }
    
    public boolean repOk()
    {
       if (dia < 1 || dia > 31 || mes < 1 || mes > 12)return false;
       return true;
    }
    
    /**
     * Agrega una temperatura al registro de temperaturas
     */
    public void agregarRegistro(int nuevaTemperatura)
    {
        assert repOk();
        assert nuevaTemperatura > -273 : "Temperatura fisicamente imposible";
        registros.add(new Integer(nuevaTemperatura));
        assert repOk();
    }
    
    /**
     * Muestra todas las temperaturas registradas en 
     * la pantalla. 
     */
    public void imprimirTemperaturas()
    {
        assert repOk();
        System.out.println(dia + "/" + mes);
        int pos = 0;
        for (Integer temperatura: registros) {
            System.out.print(pos + ": ");
            System.out.println(temperatura + "C");
            pos = pos + 1;
        }
        assert repOk();
    }
    
    public int cantTemperaturasExtremas()
    {
        assert repOk();
        int ext = 0;
        for (Integer temperatura: registros) {
            if(temperatura > 35 || temperatura < -15){
                ext = ext + 1;
            }
        }
        assert repOk();
        return ext;
    }
    
    public float promedioTemperaturas()
    {
        assert repOk();
        float promedio = 0;
        for (Integer temperatura: registros) {
            promedio += temperatura;
        }
        assert repOk();
        return promedio / registros.size();
    }
    
    public int maxTemperatura()
    {
        assert repOk();
        int max = registros.get(0);
        for (Integer temperatura: registros) {
            if (temperatura > max) {
                max = temperatura;
            }
        }
        assert repOk();
        return max;
    }
    
    public int minTemperatura()
    {
        assert repOk();
        int min = registros.get(0);
        for (Integer temperatura: registros) {
            if (temperatura < min) {
                min = temperatura;
            }
        }
        assert repOk();
        return min;
    }
    
    public int amplitudTermica()
    {
        assert repOk();
        int term = 0;
        int max = registros.get(0);
        int min = registros.get(0);
        for (Integer temperatura: registros) {
            if (temperatura > max) {
                max = temperatura;
            }
            if (temperatura < min) {
                min = temperatura;
            }
        }
        term = max - min;
        assert repOk();
        return term;
    }

    public int cantMismaTemperatura()
    {
        assert repOk();
        int counter = 0;
        int pos = 0;
        while (pos < registros.size()) {
            int actual = registros.get(pos);
            int anterior = registros.get(pos-1);
            if (actual == anterior){
                counter++;
            }
            pos++;
        }
        assert repOk();
        return counter;
    }
}
