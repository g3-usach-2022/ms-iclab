@GetMapping(path = "/estadoMundial", produces = MediaType.APPLICATION_JSON_VALUE) public @ResponseBody Mundial getTotalmundial(){

        LOGGER.log(Level.INFO, "Consulta mundial"); 

        RestTemplate restTemplate = new RestTemplate(); 
    ResponseEntity<String> call= restTemplate.getForEntity("https://api.covidl9api.com/world/total" ,String.class); 
    Mundial response = new Mundial(); 
        Gson gson = new Gson(); 
Mundial estado = gson.fromJson(call.getBody().toLowerCase(), Mundial.class);
response.setTotalConfirmed(estado.getTotalConfirmed()); 
response.setTotalDeaths(estado.getTotalDeaths()); 
response.setTotalRecovered(estado.getTotalRecovered()); 


        return response; 
} 