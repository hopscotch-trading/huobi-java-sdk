package com.hopscotchtrading.huobi_java_sdk.client;

import java.util.List;

import com.hopscotchtrading.huobi_java_sdk.client.req.account.TransferSubuserRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.subuser.GetApiKeyListRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.subuser.GetSubUserAccountListRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.subuser.GetSubUserDepositRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.subuser.GetSubUserListRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.subuser.SubUserApiKeyDeletionRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.subuser.SubUserApiKeyGenerationRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.subuser.SubUserApiKeyModificationRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.subuser.SubUserCreationRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.subuser.SubUserManagementRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.subuser.SubUserTradableMarketRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.subuser.SubUserTransferabilityRequest;
import com.hopscotchtrading.huobi_java_sdk.constant.Options;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.ExchangeEnum;
import com.hopscotchtrading.huobi_java_sdk.exception.SDKException;
import com.hopscotchtrading.huobi_java_sdk.model.account.AccountBalance;
import com.hopscotchtrading.huobi_java_sdk.model.account.SubuserAggregateBalance;
import com.hopscotchtrading.huobi_java_sdk.model.subuser.GetApiKeyListResult;
import com.hopscotchtrading.huobi_java_sdk.model.subuser.GetSubUserAccountListResult;
import com.hopscotchtrading.huobi_java_sdk.model.subuser.GetSubUserDepositResult;
import com.hopscotchtrading.huobi_java_sdk.model.subuser.GetSubUserListResult;
import com.hopscotchtrading.huobi_java_sdk.model.subuser.SubUserApiKeyGenerationResult;
import com.hopscotchtrading.huobi_java_sdk.model.subuser.SubUserApiKeyModificationResult;
import com.hopscotchtrading.huobi_java_sdk.model.subuser.SubUserCreationInfo;
import com.hopscotchtrading.huobi_java_sdk.model.subuser.SubUserManagementResult;
import com.hopscotchtrading.huobi_java_sdk.model.subuser.SubUserState;
import com.hopscotchtrading.huobi_java_sdk.model.subuser.SubUserTradableMarketResult;
import com.hopscotchtrading.huobi_java_sdk.model.subuser.SubUserTransferabilityResult;
import com.hopscotchtrading.huobi_java_sdk.model.wallet.DepositAddress;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.HuobiSubUserService;

public interface SubUserClient {


  List<SubUserCreationInfo> subuserCreation(SubUserCreationRequest request);


  GetSubUserListResult getSubUserList(GetSubUserListRequest request);

  SubUserState getSubuserState(Long subUid);

  SubUserManagementResult subuserManagement(SubUserManagementRequest request);

  GetSubUserAccountListResult getSubuserAccountList(GetSubUserAccountListRequest request);

  SubUserTransferabilityResult subuserTransferability(SubUserTransferabilityRequest request);

  SubUserTradableMarketResult subuserTradableMarket(SubUserTradableMarketRequest request);

  SubUserApiKeyGenerationResult subuserApiKeyGeneration(SubUserApiKeyGenerationRequest request);

  SubUserApiKeyModificationResult subuserApiKeyModification(SubUserApiKeyModificationRequest request);

  void subuserApiKeyDeletion(SubUserApiKeyDeletionRequest request);

  GetApiKeyListResult getApiKeyList(GetApiKeyListRequest request);

  List<DepositAddress> getSubUserDepositAddress(Long subUid, String currency);

  GetSubUserDepositResult getSubUserDeposit(GetSubUserDepositRequest request);
  /**
   * Transfer to sub-user
   * @param request
   * @return
   */
  long transferSubuser(TransferSubuserRequest request);

  /**
   * Get sub-user's account balance
   * @param subuserId
   * @return
   */
  List<AccountBalance> getSubuserAccountBalance(Long subuserId);

  /**
   * Get the aggregated balance of all sub-accounts of the current user.
   * @return
   */
  List<SubuserAggregateBalance> getSubuserAggregateBalance();

  static SubUserClient create(Options options) {

    if (options.getExchange().equals(ExchangeEnum.HUOBI)) {
      return new HuobiSubUserService(options);
    }
    throw new SDKException(SDKException.INPUT_ERROR, "Unsupport Exchange.");
  }
}
