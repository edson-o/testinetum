# Plan de pruebas para Api y Web

## parte 1: Definir casos de prueba de una pagina retail http://plazavea.com.pe/
  # ruta del file = resources/casosDePrueba/casosdepruebaP1.txt

## parte 2: test automation framework from scratch para WEB
  # se uso las tools de, Screenplay, SerenityBDD, Cucumber, Java
  # feature de prueba path=resources/features/web.feature


## parte 3: test automation framework from scratch para API
  # se uso las tools de, Screenplay, SerenityBDD, Cucumber, Java, RestAssured
  # feature de prueba path=resources/features/api.feature

## parte 4: Pruebas de performance
  Numero de usuarios: 200
  Ramp-up = 10s
  Duracion Total = 60s
  Loop = Forever

  # Metricas Analizadas: Total de peticiones, Tiempo maximo de respuesta, procentaje y detalle de errores
  # Evidencias: Captura de pantalla y archivo .jmx 
  #path=resources/jmeter/reqrestest.jmx #summary.png #viewtree.png


## parte 5: Evidencia portal avianca
  -	Busqueda de Vuelos: Lima – Aruba
  -	Pasajeros: 4
  -	Medir el tiempo manualmente con cronometro
    Intento 1: 3.91 segundos
    Intento 2: 3.20 segundos
    Intento 3: 2.97 segundos
