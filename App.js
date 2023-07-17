/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React from 'react';
import type {Node} from 'react';
import {
  SafeAreaView,
  ScrollView,
  StatusBar,
  StyleSheet,
  Text,
  useColorScheme,
  View, Button, NativeModules
} from 'react-native';

import {
  Colors,
  DebugInstructions,
  Header,
  LearnMoreLinks,
  ReloadInstructions,
} from 'react-native/Libraries/NewAppScreen';

const { PointClickOfferwallModule } = NativeModules;

const App: () => Node = () => {
  const isDarkMode = useColorScheme() === 'dark';

  const backgroundStyle = {
      backgroundColor: isDarkMode ? Colors.darker : Colors.lighter,
  };

  const BUTTON_TEMPLATE = {
    OFFERWALL_BTN_PRIMARY: 5,
    OFFERWALL_BTN_GRREN: 6,
    OFFERWALL_BTN_PURPLE: 7,
    OFFERWALL_BTN_RED: 8,
    OFFERWALL_BTN_YELLOW: 9
  }

  return (
      <SafeAreaView style={backgroundStyle}>
          <View
              style={{
                  flexDirection: "column",
                  height: "100%",
                  padding: 20
              }}
          >
              <Button
                  onPress={async () => { await PointClickOfferwallModule.showOfferwall('test', BUTTON_TEMPLATE.OFFERWALL_BTN_PRIMARY); }}
                  title="Open Offerwall"
                  color="#841584"
                  accessibilityLabel="Learn more about this purple button"
              />
          </View>
      </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  sectionContainer: {
      marginTop: 32,
      paddingHorizontal: 24,
  },
  sectionTitle: {
      fontSize: 24,
      fontWeight: '600',
  },
  sectionDescription: {
      marginTop: 8,
      fontSize: 18,
      fontWeight: '400',
  },
  highlight: {
      fontWeight: '700',
  },
});

export default App;
