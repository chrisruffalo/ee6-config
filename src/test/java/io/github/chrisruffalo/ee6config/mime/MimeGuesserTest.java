package io.github.chrisruffalo.ee6config.mime;

import io.github.chrisruffalo.ee6config.resources.configuration.source.ResourceConfigurationSource;
import io.github.chrisruffalo.ee6config.resources.configuration.source.UnfoundConfigurationSource;

import org.junit.Assert;
import org.junit.Test;

public class MimeGuesserTest {

	@Test
	public void testUnfoundSource() {
		UnfoundConfigurationSource source = new UnfoundConfigurationSource();
		SupportedType type = MimeGuesser.guess(source);
		Assert.assertEquals(SupportedType.TEXT, type);
	}
	
	@Test
	public void testPropertiesFile() {
		ResourceConfigurationSource source = new ResourceConfigurationSource("properties/priority1.properties");
		SupportedType type = MimeGuesser.guess(source);
		Assert.assertEquals(SupportedType.TEXT, type);
	}

	@Test
	public void testXmlFile() {
		ResourceConfigurationSource source = new ResourceConfigurationSource("xml/priority4.xml");
		SupportedType type = MimeGuesser.guess(source);
		Assert.assertEquals(SupportedType.XML, type);
	}
	
	@Test
	public void testYamlFile() {
		ResourceConfigurationSource source = new ResourceConfigurationSource("yaml/priority6.yaml");
		SupportedType type = MimeGuesser.guess(source);
		Assert.assertEquals(SupportedType.YAML, type);
	}
	
	@Test
	public void testJsonFile() {
		ResourceConfigurationSource source = new ResourceConfigurationSource("json/priority7.json");
		SupportedType type = MimeGuesser.guess(source);
		Assert.assertEquals(SupportedType.JSON, type);	
	}
	
}

