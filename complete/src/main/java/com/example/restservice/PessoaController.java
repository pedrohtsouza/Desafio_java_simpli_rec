package com.example.restservice;

public class PessoaController {
	  Autowired
	    private PessoaDAO pessoaDAO;
	  @GetMapping("/pessoas")
	  public List<Pessoa> getAllPessoas() {
	      return pessoaDAO.getAllPessoas();
	  }

	  @PostMapping("/pessoas")
	  public void addPessoa(RequestBody Pessoa pessoa) {
	      pessoaDAO.addPessoa(pessoa);
	      enviarSms(pessoa.getTelefone(), "Sua senha é: " + pessoa.getPosicao());
	  }

	  @GetMapping("/pessoas/{id}")
	  public Pessoa getPessoaById(PathVariable int id) {
	      return pessoaDAO.getPessoaById(id);
	  }

	  @PutMapping("/pessoas/{id}")
	  public void updatePessoa(PathVariable int id, RequestBody Pessoa pessoa) {
	      pessoa.setId(id);
	      pessoaDAO.updatePessoa(pessoa);
	  }

	  @DeleteMapping("/pessoas/{id}")
	  public void deletePessoa(PathVariable int id) {
	      pessoaDAO.deletePessoa(id);
	  }
	  private void enviarSms(String telefone, String mensagem) {
		    String customerId = "SEU_CUSTOMER_ID";
		    String apiKey = "SEU_API_KEY";
		    String phone = telefone;
		    String message = mensagem;
		    
		    try {
		        TelesignClient client = new TelesignClient(customerId, apiKey);
		        Sms sms = new Sms(phone, message);
		        sms.messageType = "ARN";
		        sms.setSenderId("SMS Test");
		        sms.setExternalId("your-external-id");
		        client.message(sms);
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}

}
