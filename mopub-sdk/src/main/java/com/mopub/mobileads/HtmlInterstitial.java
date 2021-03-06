package com.mopub.mobileads;

import java.util.Map;

import static com.mopub.common.DataKeys.CLICKTHROUGH_URL_KEY;
import static com.mopub.common.DataKeys.HTML_RESPONSE_BODY_KEY;
import static com.mopub.common.DataKeys.REDIRECT_URL_KEY;
import static com.mopub.common.DataKeys.SCROLLABLE_KEY;

public class HtmlInterstitial extends ResponseBodyInterstitial {
    private String mHtmlData;
    private boolean mIsScrollable;
    private String mRedirectUrl;
    private String mClickthroughUrl;

    @Override
    protected void extractExtras(Map<String, String> serverExtras) {
        mHtmlData = serverExtras.get(HTML_RESPONSE_BODY_KEY);
        mIsScrollable = Boolean.valueOf(serverExtras.get(SCROLLABLE_KEY));
        mRedirectUrl = serverExtras.get(REDIRECT_URL_KEY);
        mClickthroughUrl = serverExtras.get(CLICKTHROUGH_URL_KEY);
    }

    @Override
    protected void preRenderHtml(CustomEventInterstitialListener customEventInterstitialListener) {
        MoPubActivity.preRenderHtml(mContext, mAdReport, customEventInterstitialListener, mHtmlData);
    }

    @Override
    public void showInterstitial() {
        MoPubActivity.start(mContext, mHtmlData, mAdReport, mIsScrollable, mRedirectUrl, mClickthroughUrl, mBroadcastIdentifier);
    }
}
