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
    public MedicionesTemperaturas(int dia, int mes) {
        assert dia >= 1 && dia <= 31;
        assert mes >= 1 && mes <= 12;
        this.dia = dia;
        this.mes = mes;
        this.registros = new ArrayList<Integer>();
    }
    
    /**
     * Agrega una temperatura al registro de temperaturas
     */
    public void agregarRegistro(int nuevaTemperatura) {
        assert nuevaTemperatura > -273 : "Temperatura fisicamente imposible";
        registros.add(new Integer(nuevaTemperatura));
    }
    
    /**
     * Muestra todas las temperaturas registradas en 
     * la pantalla. 
     */
    public void imprimirTemperaturas() {
        System.out.println(dia + "/" + mes);
        int pos = 0;
        for (Integer temperatura: registros) {
            System.out.print(pos + ": ");
            System.out.println(temperatura + "C");
            pos = pos + 1;
        }
    }
    
    public int cantTemperaturasExtremas() {
        int ext = 0;
        for (Integer temperatura: registros) {
            if(temperatura > 35 || temperatura < -15){
                ext = ext + 1;
            }
        }
        return ext;
    }
    
    public int promedioTemperaturas() {
        int promedio = 0;
        for (Integer temperatura: registros) {
            promedio += temperatura;
        }
        return promedio / registros.size();
    }
    
    public int maxTemperatura() {
        int max = registros.get(0);
        for (Integer temperatura: registros) {
            if (temperatura > max) {
                max = temperatura;
            }
        }
        return max;
    }
    
    public int minTemperatura() {
        int min = registros.get(0);
        for (Integer temperatura: registros) {
            if (temperatura < min) {
                min = temperatura;
            }
        }
        return min;
    }
    
    public int amplitudTermica() {
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
        return term;
    }
}
