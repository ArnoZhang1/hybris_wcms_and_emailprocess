/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.training.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.Breadcrumb;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.constants.WebConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;

import de.hybris.platform.commerceservices.model.process.StoreFrontCustomerProcessModel;
import de.hybris.platform.commerceservices.model.process.TrainingProcessModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.customerticketingaddon.constants.CustomerticketingaddonConstants;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.store.services.BaseStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;


/**
 * Controller for home page
 */
@Controller
@RequestMapping("/")
public class HomePageController extends AbstractPageController {
	private static final String LOGOUT = "logout";
	private static final String ACCOUNT_CONFIRMATION_SIGNOUT_TITLE = "account.confirmation.signout.title";
	private static final String ACCOUNT_CONFIRMATION_CLOSE_TITLE = "account.confirmation.close.title";

	@RequestMapping(method = RequestMethod.GET)
	public String home(@RequestParam(value = WebConstants.CLOSE_ACCOUNT, defaultValue = "false") final boolean closeAcc,
					   @RequestParam(value = LOGOUT, defaultValue = "false") final boolean logout, final Model model,
					   final RedirectAttributes redirectModel) throws CMSItemNotFoundException {
		if (logout) {
			String message = ACCOUNT_CONFIRMATION_SIGNOUT_TITLE;
			if (closeAcc) {
				message = ACCOUNT_CONFIRMATION_CLOSE_TITLE;
			}
			GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.INFO_MESSAGES_HOLDER, message);
			return REDIRECT_PREFIX + ROOT;
		}

		storeCmsPageInModel(model, getContentPageForLabelOrId(null));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(null));
		updatePageTitle(model, getContentPageForLabelOrId(null));

		return getViewForPage(model);
	}
	//htahtraining start
	@RequestMapping(value = "/goTrainingPage1", method = RequestMethod.GET)
	public String goTrainingPage1(final Model model) throws CMSItemNotFoundException {
		storeCmsPageInModel(model, getContentPageForLabelOrId("trainingPage1"));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId("trainingPage1"));
		updatePageTitle(model, getContentPageForLabelOrId("trainingPage1"));
		model.addAttribute("breadcumbcomponentTest", "测试从controller中传数据到组件中");
		System.out.println("11");
		model.addAttribute("breadcrumbs", getBreadcrumbs());
		return getViewForPage(model);
	}

	@RequestMapping(value = "/goTrainingPage2", method = RequestMethod.GET)
	public String goTrainingPage2(final Model model) throws CMSItemNotFoundException {
		System.out.println("22");
		storeCmsPageInModel(model, getContentPageForLabelOrId("trainingPage2"));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId("trainingPage2"));
		updatePageTitle(model, getContentPageForLabelOrId("trainingPage2"));
		model.addAttribute("breadcrumbs", getBreadcrumbs());
		return getViewForPage(model);
	}


	protected void updatePageTitle(final Model model, final AbstractPageModel cmsPage) {
		storeContentPageTitleInModel(model, getPageTitleResolver().resolveHomePageTitle(cmsPage.getTitle()));
	}

	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	protected List<Breadcrumb> getBreadcrumbs() {
		final List<Breadcrumb> breadcrumbs = accountBreadcrumbBuilder.getBreadcrumbs(null);
		breadcrumbs.add(new Breadcrumb("/my-account/support-tickets", getMessageSource().getMessage(
				CustomerticketingaddonConstants.TEXT_SUPPORT_TICKETING_HISTORY, null, getI18nService().getCurrentLocale()), null));
		breadcrumbs.add(
				new Breadcrumb("#", "name1", null));
		return breadcrumbs;
	}
	//htahtraining end

}