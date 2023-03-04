package com.example.restservice;

public class PessoaDAO {
private final EntityManager entityManager;
    
    public PessoaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public void cadastrar(Pessoa pessoa) {
        entityManager.getTransaction().begin();
        entityManager.persist(pessoa);
        entityManager.getTransaction().commit();
    }
    
    public void atualizar(Pessoa pessoa) {
        entityManager.getTransaction().begin();
        entityManager.merge(pessoa);
        entityManager.getTransaction().commit();
    }
    
    public void excluir(Pessoa pessoa) {
        entityManager.getTransaction().begin();
        entityManager.remove(pessoa);
        entityManager.getTransaction().commit();
    }
    
    public Pessoa buscarPorId(Long id) {
        return entityManager.find(Pessoa.class, id);
    }
    
    public List<Pessoa> buscarTodos() {
        CriteriaQuery<Pessoa> cq = entityManager.getCriteriaBuilder().createQuery(Pessoa.class);
        cq.select(cq.from(Pessoa.class));
        return entityManager.createQuery(cq).getResultList();
    }
    
    public List<Pessoa> buscarPorPosicaoFilaMaiorQue(int posicao) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Pessoa> cq = cb.createQuery(Pessoa.class);
        Root<Pessoa> root = cq.from(Pessoa.class);
        cq.select(root).where(cb.greaterThan(root.get("posicaoFila"), posicao));
        return entityManager.createQuery(cq).getResultList();
    }
}
