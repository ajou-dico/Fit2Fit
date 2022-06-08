package com.dico.fit2fit;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class viewModel extends ViewModel {
        private MutableLiveData<String> currentName;
        public MutableLiveData<String> getCurrentName() {
            if (currentName == null) {
                currentName = new MutableLiveData<String>();
            }
            return currentName;
        }
    }
