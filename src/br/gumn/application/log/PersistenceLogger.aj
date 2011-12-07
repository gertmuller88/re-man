package br.gumn.application.log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import br.gumn.application.persistence.util.AbstractDAO;

/**
 * Aspecto responsável pela geração do log de persistência.
 * 
 * @author Gert Uchôa Müller Neto
 * @version v2.08112011.2240
 */
public aspect PersistenceLogger {
	private static File file;
	private static FileOutputStream fos;
	private static PrintWriter out;
	private static SimpleDateFormat sdf;
	
	/**
	 * Método responsável por gravar o log no arquivo.
	 */
	public void updateFile() {
		try {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			file = new File("WebContent/logs/persistence." + sdf.format(new Date()) + ".txt");
			fos = new FileOutputStream(file, true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		out = new PrintWriter(fos);
	}
	
	pointcut persist(Object o) : execution(* AbstractDAO+.persist(*)) && args(o);
	pointcut merge(Object o) : execution(* AbstractDAO+.merge(*)) && args(o);
	pointcut remove(Object o) : execution(* AbstractDAO+.remove(*)) && args(o);
	
	before(Object o) : persist(o) {
		this.updateFile();
		out.println("/--------------------------------------------- PERSIST ---------------------------------------------/");
		out.println(new Date().toString() + " - Persisting " + o.toString() + ".");
		out.flush();
	}
	
	after(Object o) returning(Object ob) : persist(o) {
		this.updateFile();
		out.println(new Date().toString() + " - Persisting return of " + o.toString() + ": " + ob.toString() + ".");
		out.flush();
	}
	
	after(Object o) throwing(Exception e) : persist(o) {
		this.updateFile();
		out.println(new Date().toString() + " - Exception in persisting of " + o.toString() + ".");
		out.println("								   - Exception Message: " + e.getMessage());
		out.println("								   - Exception Cause: " + e.getCause().getMessage());
		out.flush();
	}
	
	after(Object o) : persist(o) {
		this.updateFile();
		out.println(new Date().toString() + " - End persisting " + o.toString() + ".");
		out.println("/---------------------------------------------------------------------------------------------------/");
		out.println();
		out.flush();
	}
	
	before(Object o) : merge(o) {
		this.updateFile();
		out.println("/---------------------------------------------- MERGE ----------------------------------------------/");
		out.println(new Date().toString() + " - Merging " + o.toString() + ".");
		out.flush();
	}
	
	after(Object o) returning(Object ob) : merge(o) {
		this.updateFile();
		out.println(new Date().toString() + " - Merging return of " + o.toString() + ": " + ob.toString() + ".");
		out.flush();
	}
	
	after(Object o) throwing(Exception e) : merge(o) {
		this.updateFile();
		out.println(new Date().toString() + " - Exception in merging of " + o.toString() + ".");
		out.println("								   - Exception Message: " + e.getMessage());
		out.println("								   - Exception Cause: " + e.getCause().getMessage());
		out.flush();
	}
	
	after(Object o) : merge(o) {
		this.updateFile();
		out.println(new Date().toString() + " - End merging " + o.toString() + ".");
		out.println("/---------------------------------------------------------------------------------------------------/");
		out.println();
		out.flush();
	}
	
	before(Object o) : remove(o) {
		this.updateFile();
		out.println("/---------------------------------------------- REMOVE ---------------------------------------------/");
		out.println(new Date().toString() + " - Removing " + o.toString() + ".");
		out.flush();
	}
	
	after(Object o) returning(Object ob) : remove(o) {
		this.updateFile();
		out.println(new Date().toString() + " - Removing return of " + o.toString() + ": " + ob.toString() + ".");
		out.flush();
	}
	
	after(Object o) throwing(Exception e) : remove(o) {
		this.updateFile();
		out.println(new Date().toString() + " - Exception in removing of " + o.toString() + ".");
		out.println("								   - Exception Message: " + e.getMessage());
		out.println("								   - Exception Cause: " + e.getCause().getMessage());
		out.flush();
	}
	
	after(Object o) : remove(o) {
		this.updateFile();
		out.println(new Date().toString() + " - End removing " + o.toString() + ".");
		out.println("/---------------------------------------------------------------------------------------------------/");
		out.println();
		out.flush();
	}
}
