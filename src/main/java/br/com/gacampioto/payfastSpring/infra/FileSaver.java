package br.com.gacampioto.payfastSpring.infra;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {
	@Autowired
	private HttpServletRequest request;
	
	public String saveToServer(MultipartFile comprovante, String basePath){
		String realPath = request.getServletContext().getRealPath("/" + basePath);
		String path = realPath + "/" + comprovante.getOriginalFilename();
		System.out.println("realPath: " + realPath);
		System.out.println("path: " + path);
		try {
			comprovante.transferTo(new File(path));
			return basePath + "/" + comprovante.getOriginalFilename();
		} catch (IllegalStateException | IOException e) {
			throw new RuntimeException(e);
		}
	}
}
