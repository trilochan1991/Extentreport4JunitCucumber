package iocucumber.base.configurationprovider;

import iocucumber.base.framework.BaseConfig;
import iocucumber.base.pageobjectmanager.PageobjectManager;

public class ConfigurationProvider {

	private BaseConfig baseConfig;
	private PageobjectManager PageobjectManager;

	public ConfigurationProvider() {
		baseConfig = new BaseConfig();
		PageobjectManager = new PageobjectManager(baseConfig.getDriver());
	}

	public BaseConfig getBaseConfigInstance() {
		return baseConfig;
	}

	public PageobjectManager getPageobjectManagerInstance() {
		return PageobjectManager;
	}

}
