import { defaultChartsConfig, defineConfig } from "allure";

const comboRules = [
  {
    name: "Layer / Severity+Layer / Msg / EnvGroup",
    matchers: { labels: { layer: /.+/ } },
    groupBy: ["severity", { label: "layer" }],
    groupByMessage: true,
    groupEnvironments: true,
  },
  {
    name: "Owner / Owner / Msg",
    matchers: { labels: { owner: /.+/ } },
    groupBy: ["owner"],
    groupByMessage: true,
    groupEnvironments: false,
  },
  {
    name: "Feature / Status / EnvGroup",
    matchers: { labels: { feature: /.+/ } },
    groupBy: ["status"],
    groupByMessage: false,
    groupEnvironments: true,
  },
  {
    name: "Story / Transition+Env",
    matchers: { labels: { story: /.+/ } },
    groupBy: ["transition", "environment"],
    groupByMessage: false,
    groupEnvironments: false,
  },
  {
    name: "Transitions / Transition+EnvGroup",
    matchers: { transitions: ["new", "fixed", "regressed", "malfunctioned"] },
    groupBy: ["transition", "environment"],
    groupByMessage: false,
    groupEnvironments: true,
  },
  {
    name: "Flaky / Flaky / Msg",
    matchers: { flaky: true },
    groupBy: ["flaky"],
    groupByMessage: true,
    groupEnvironments: false,
  },
  {
    name: "Non-flaky / Flaky / Msg",
    matchers: { flaky: false },
    groupBy: ["flaky"],
    groupByMessage: true,
    groupEnvironments: false,
  },
  {
    name: "Feature+Story / EnvGroup",
    matchers: { labels: { feature: /.+/, story: /.+/ } },
    groupBy: [{ label: "feature" }, { label: "story" }],
    groupByMessage: false,
    groupEnvironments: true,
  },
  {
    name: "Env label / Environment / Msg",
    matchers: { labels: { env: /.+/ } },
    groupBy: ["environment"],
    groupByMessage: true,
  },
];

export default defineConfig({
  name: "Allure Report",
  output: "./allure-report",
  historyPath: "./history.jsonl",
  categories: {
    rules: comboRules,
  },
  plugins: {
    testops: {
      options: { },
    },
  },
  variables: { },
  environments: {},
});
