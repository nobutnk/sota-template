# sota-template
template project for Sota

----

## 構成

1. SotaMain
    * config.xmlを読み込みます。config.xmlは設定ファイル
    * 設定情報はSotaConfigとして渡されます。
2. Executorが実行されます。
    * Executor: jp.vstone.sota.executor.Executor
    * 基本的にはSimpleExecutorを使う
3. サービスが実行されます。
    * SotaServiceを実装したServiceが起動されます。
    * 実行されるサービスは、config.xmlのsota.serviceに記述されたサービス。Qualified Name.
4. Sotaの操作は、controller.SotaXXXControllerを通して行う。
    * Mock作成しやすいようにWrapperを作成しています。
    