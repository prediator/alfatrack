package ua.pogodin.webapp.dao.impl;

import javax.persistence.EntityManager;

public class BaseHiberDao {

	private static EntityManager em = null;

	public EntityManager getEm() {
		if (em == null) {
			em = getNewEm();
		}
		return em;
	}

	private EntityManager getNewEm() {
		return HibernateUtil.getEjb3Configuration().buildEntityManagerFactory().createEntityManager();
	}

	public void begin() {
		if (em == null || !em.isOpen()) {
			em = getNewEm();
		}
		if (!em.getTransaction().isActive()) {
			em.getTransaction().begin();
		}
	}

	public void persist(Object obj) {
			em.persist(obj);
	}

	public void closeAll() {

		if (em != null && em.isOpen()) {
			em.close();
		}
	}

	public void commit() {
		if (em != null) {
			em.getTransaction().commit();
		}
	}
}
