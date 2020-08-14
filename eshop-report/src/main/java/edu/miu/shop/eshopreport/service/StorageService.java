package edu.miu.shop.eshopreport.service;
import java.io.File;

/**
 * @author Julius Krah
 *
 */
public interface StorageService {
	void init();

	void deleteAll();

	boolean jrxmlFileExists(String file);

	boolean jasperFileExists(String file);

	String loadJrxmlFile(String file);

	File loadJasperFile(String file);

}
