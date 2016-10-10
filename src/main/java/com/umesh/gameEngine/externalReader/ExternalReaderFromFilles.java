package com.umesh.gameEngine.externalReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import com.umesh.gameEngine.Game.Game;
import com.umesh.gameEngine.Game.GameConfiguration;
import com.umesh.gameEngine.utils.GameConstants;

public class ExternalReaderFromFilles implements ExternalReader {

	@Override
	public Map<String, String> getPropertyMapFromEntity(String entityName) {
		Properties prop = new Properties();

		try (InputStream input = new FileInputStream(GameConstants.BASE_PATH + GameConfiguration.getGameName()
				+ File.separator + entityName + ".properties")) {
			prop.load(input);
			Map<String, String> entityMap = prop.entrySet().stream()
					.collect(Collectors.toMap(e -> (String) e.getKey(), e -> (String) e.getValue()));
			return entityMap;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public String getMessageForDisplay(String entity) {
		StringBuffer buffer = new StringBuffer();
		try (BufferedReader br = new BufferedReader(new FileReader(GameConstants.BASE_PATH
				+ GameConfiguration.getGameName() + File.separator + entity + ".msg"))) {
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				buffer.append(sCurrentLine + "\n");

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}

}
