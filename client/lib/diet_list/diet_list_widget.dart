import '/backend/api_requests/api_calls.dart';
import '/flutter_flow/flutter_flow_data_table.dart';
import '/flutter_flow/flutter_flow_drop_down.dart';
import '/flutter_flow/flutter_flow_theme.dart';
import '/flutter_flow/flutter_flow_util.dart';
import '/flutter_flow/flutter_flow_widgets.dart';
import '/flutter_flow/form_field_controller.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:provider/provider.dart';
import 'diet_list_model.dart';
export 'diet_list_model.dart';

class DietListWidget extends StatefulWidget {
  const DietListWidget({super.key});

  @override
  State<DietListWidget> createState() => _DietListWidgetState();
}

class _DietListWidgetState extends State<DietListWidget> {
  late DietListModel _model;

  final scaffoldKey = GlobalKey<ScaffoldState>();

  @override
  void initState() {
    super.initState();
    _model = createModel(context, () => DietListModel());
  }

  @override
  void dispose() {
    _model.dispose();

    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    context.watch<FFAppState>();

    return GestureDetector(
      onTap: () => FocusScope.of(context).unfocus(),
      child: Scaffold(
        key: scaffoldKey,
        backgroundColor: FlutterFlowTheme.of(context).primaryBackground,
        appBar: AppBar(
          backgroundColor: FlutterFlowTheme.of(context).primary,
          automaticallyImplyLeading: false,
          title: Text(
            'Diet Planner',
            style: FlutterFlowTheme.of(context).headlineMedium.override(
                  fontFamily: 'Inter Tight',
                  color: Colors.white,
                  fontSize: 22.0,
                  letterSpacing: 0.0,
                ),
          ),
          actions: [],
          centerTitle: false,
          elevation: 2.0,
        ),
        body: SafeArea(
          top: true,
          child: Column(
            mainAxisSize: MainAxisSize.max,
            children: [
              Container(
                width: MediaQuery.sizeOf(context).width * 1.0,
                height: MediaQuery.sizeOf(context).height * 0.8,
                decoration: BoxDecoration(
                  color: FlutterFlowTheme.of(context).secondaryBackground,
                ),
                child: Column(
                  mainAxisSize: MainAxisSize.max,
                  children: [
                    Padding(
                      padding: const EdgeInsetsDirectional.fromSTEB(
                          10.0, 10.0, 0.0, 10.0),
                      child: Row(
                        mainAxisSize: MainAxisSize.max,
                        children: [
                          FFButtonWidget(
                              text: 'Sort',
                              onPressed: () async {
                                showModalBottomSheet(
                                    context: context,
                                    builder: (BuildContext context) {
                                      return SizedBox(
                                          height: 200,
                                          child: Center(
                                            child: Column(
                                              mainAxisSize: MainAxisSize.max,
                                              children: [
                                                Padding(
                                                  padding:
                                                      const EdgeInsetsDirectional
                                                          .fromSTEB(
                                                          0.0, 40.0, 0.0, 0.0),
                                                  child: Row(children: [
                                                    Column(
                                                      children: [
                                                        Row(children: [
                                                          Padding(
                                                            padding:
                                                                const EdgeInsetsDirectional
                                                                    .fromSTEB(
                                                                    40,
                                                                    0,
                                                                    20,
                                                                    0),
                                                            child: Text(
                                                              'Nutrient Option',
                                                              style: FlutterFlowTheme
                                                                      .of(context)
                                                                  .bodyMedium
                                                                  .override(
                                                                    fontFamily:
                                                                        'Inter',
                                                                    fontSize:
                                                                        18,
                                                                    letterSpacing:
                                                                        0.0,
                                                                  ),
                                                            ),
                                                          ),
                                                          FlutterFlowDropDown<
                                                              String>(
                                                            controller: _model
                                                                    .dropDownValueController1 ??=
                                                                FormFieldController<
                                                                        String>(
                                                                    null),
                                                            options: const [
                                                              'Calorie',
                                                              'Carbohydrate',
                                                              'Protein',
                                                              'Province'
                                                            ],
                                                            onChanged: (val) =>
                                                                safeSetState(() =>
                                                                    _model.dropDownValue1 =
                                                                        val),
                                                            width: MediaQuery
                                                                        .sizeOf(
                                                                            context)
                                                                    .width *
                                                                0.35,
                                                            height: 40.0,
                                                            textStyle:
                                                                FlutterFlowTheme.of(
                                                                        context)
                                                                    .bodyMedium
                                                                    .override(
                                                                      fontFamily:
                                                                          'Inter',
                                                                      letterSpacing:
                                                                          0.0,
                                                                    ),
                                                            hintText:
                                                                'Select...',
                                                            icon: Icon(
                                                              Icons
                                                                  .keyboard_arrow_down_rounded,
                                                              color: FlutterFlowTheme
                                                                      .of(context)
                                                                  .secondaryText,
                                                              size: 24.0,
                                                            ),
                                                            fillColor: FlutterFlowTheme
                                                                    .of(context)
                                                                .secondaryBackground,
                                                            elevation: 2.0,
                                                            borderColor: Colors
                                                                .transparent,
                                                            borderWidth: 0.0,
                                                            borderRadius: 8.0,
                                                            margin:
                                                                const EdgeInsetsDirectional
                                                                    .fromSTEB(
                                                                    12.0,
                                                                    0.0,
                                                                    12.0,
                                                                    0.0),
                                                            hidesUnderline:
                                                                true,
                                                            isOverButton: false,
                                                            isSearchable: false,
                                                            isMultiSelect:
                                                                false,
                                                          )
                                                        ]),
                                                        Row(children: [
                                                          Padding(
                                                            padding:
                                                                const EdgeInsetsDirectional
                                                                    .fromSTEB(
                                                                        40,
                                                                        0,
                                                                        54,
                                                                        0),
                                                            child: Text(
                                                              'Sort Option',
                                                              style: FlutterFlowTheme
                                                                      .of(context)
                                                                  .bodyMedium
                                                                  .override(
                                                                    fontFamily:
                                                                        'Inter',
                                                                    fontSize:
                                                                        18,
                                                                    letterSpacing:
                                                                        0.0,
                                                                  ),
                                                            ),
                                                          ),
                                                          FlutterFlowDropDown<
                                                              String>(
                                                            controller: _model
                                                                    .dropDownValueController2 ??=
                                                                FormFieldController<
                                                                        String>(
                                                                    null),
                                                            options: const [
                                                              'Upper',
                                                              'Lower'
                                                            ],
                                                            onChanged: (val) =>
                                                                safeSetState(() =>
                                                                    _model.dropDownValue2 =
                                                                        val),
                                                            width: MediaQuery
                                                                        .sizeOf(
                                                                            context)
                                                                    .width *
                                                                0.35,
                                                            height: 40.0,
                                                            textStyle:
                                                                FlutterFlowTheme.of(
                                                                        context)
                                                                    .bodyMedium
                                                                    .override(
                                                                      fontFamily:
                                                                          'Inter',
                                                                      letterSpacing:
                                                                          0.0,
                                                                    ),
                                                            hintText:
                                                                'Select...',
                                                            icon: Icon(
                                                              Icons
                                                                  .keyboard_arrow_down_rounded,
                                                              color: FlutterFlowTheme
                                                                      .of(context)
                                                                  .secondaryText,
                                                              size: 24.0,
                                                            ),
                                                            fillColor: FlutterFlowTheme
                                                                    .of(context)
                                                                .secondaryBackground,
                                                            elevation: 2.0,
                                                            borderColor: Colors
                                                                .transparent,
                                                            borderWidth: 0.0,
                                                            borderRadius: 8.0,
                                                            margin:
                                                                const EdgeInsetsDirectional
                                                                    .fromSTEB(
                                                                    12.0,
                                                                    0.0,
                                                                    12.0,
                                                                    0.0),
                                                            hidesUnderline:
                                                                true,
                                                            isOverButton: false,
                                                            isSearchable: false,
                                                            isMultiSelect:
                                                                false,
                                                          ),
                                                        ]),
                                                      ],
                                                    ),
                                                    Padding(
                                                      padding:
                                                          const EdgeInsetsDirectional
                                                              .fromSTEB(0.0,
                                                              0.0, 0.0, 0.0),
                                                      child: FFButtonWidget(
                                                        onPressed: () async {
                                                          FFAppState()
                                                                  .NutrientOption =
                                                              _model
                                                                  .dropDownValue1
                                                                  .toString();
                                                          FFAppState()
                                                                  .SortOption =
                                                              _model
                                                                  .dropDownValue2
                                                                  .toString();
                                                          _model.apiResultsort =
                                                              await SortDietListCall
                                                                  .call();

                                                          if ((_model.apiResultsort?.succeeded ??
                                                              true)) {
                                                            FFAppState()
                                                                .DietList = [];
                                                            safeSetState(() {});
                                                            FFAppState()
                                                                .DietList = (_model
                                                                        .apiResultsort
                                                                        ?.jsonBody ??
                                                                    '')
                                                                .toList()
                                                                .cast<
                                                                    dynamic>();
                                                            safeSetState(() {});
                                                          } else {
                                                            await showDialog(
                                                              context: context,
                                                              builder:
                                                                  (alertDialogContext) {
                                                                return AlertDialog(
                                                                  title: const Text(
                                                                      'Sort Diet List'),
                                                                  content:
                                                                      const Text(
                                                                          'API Call failed!'),
                                                                  actions: [
                                                                    TextButton(
                                                                      onPressed:
                                                                          () =>
                                                                              Navigator.pop(alertDialogContext),
                                                                      child: const Text(
                                                                          'Ok'),
                                                                    ),
                                                                  ],
                                                                );
                                                              },
                                                            );
                                                          }
                                                          safeSetState(() {});
                                                        },
                                                        text: 'Sort',
                                                        options:
                                                            FFButtonOptions(
                                                          height: 40.0,
                                                          padding:
                                                              const EdgeInsetsDirectional
                                                                  .fromSTEB(
                                                                  16.0,
                                                                  0.0,
                                                                  16.0,
                                                                  0.0),
                                                          iconPadding:
                                                              const EdgeInsetsDirectional
                                                                  .fromSTEB(
                                                                  0.0,
                                                                  0.0,
                                                                  0.0,
                                                                  0.0),
                                                          color: FlutterFlowTheme
                                                                  .of(context)
                                                              .primary,
                                                          textStyle:
                                                              FlutterFlowTheme.of(
                                                                      context)
                                                                  .titleSmall
                                                                  .override(
                                                                    fontFamily:
                                                                        'Inter Tight',
                                                                    color: Colors
                                                                        .white,
                                                                    letterSpacing:
                                                                        0.0,
                                                                  ),
                                                          elevation: 0.0,
                                                          borderRadius:
                                                              BorderRadius
                                                                  .circular(
                                                                      24.0),
                                                        ),
                                                      ),
                                                    ),
                                                  ]),
                                                )
                                              ],
                                            ),
                                          ));
                                    });
                              },
                              options: FFButtonOptions(
                                height: 40.0,
                                padding: const EdgeInsetsDirectional.fromSTEB(
                                    16.0, 0.0, 16.0, 0.0),
                                iconPadding:
                                    const EdgeInsetsDirectional.fromSTEB(
                                        0.0, 0.0, 0.0, 0.0),
                                color: FlutterFlowTheme.of(context).primary,
                                textStyle: FlutterFlowTheme.of(context)
                                    .titleSmall
                                    .override(
                                      fontFamily: 'Inter Tight',
                                      color: Colors.white,
                                      letterSpacing: 0.0,
                                    ),
                                elevation: 0.0,
                                borderRadius: BorderRadius.circular(24.0),
                              )),
                          Padding(
                            padding: const EdgeInsetsDirectional.fromSTEB(
                                16.0, 0.0, 16.0, 0.0),
                            child: FFButtonWidget(
                              text: 'Search',
                              onPressed: () async {
                                showModalBottomSheet(
                                    context: context,
                                    builder: (BuildContext context) {
                                      return SizedBox(
                                        height: 400,
                                        child: Row(
                                          children: [
                                          Column(
                                            mainAxisSize: MainAxisSize.max,
                                            children: [
                                              Expanded(
                                                child: Padding(
                                                  padding: const EdgeInsetsDirectional.fromSTEB(
                                                      20.0, 0.0, 10.0, 15.0),
                                                  child: SizedBox(
                                                    width: 200.0,
                                                    child: TextFormField(
                                                      controller: _model.searchRiceTextController,
                                                      focusNode: _model.searchRiceFocusNode,
                                                      autofocus: false,
                                                      obscureText: false,
                                                      decoration: InputDecoration(
                                                        isDense: true,
                                                        labelText: 'Rice',
                                                        labelStyle: FlutterFlowTheme.of(context)
                                                            .labelMedium
                                                            .override(
                                                              fontFamily: 'Inter',
                                                              letterSpacing: 0.0,
                                                            ),
                                                        hintText: 'Search Rice',
                                                        hintStyle: FlutterFlowTheme.of(context)
                                                            .labelMedium
                                                            .override(
                                                              fontFamily: 'Inter',
                                                              letterSpacing: 0.0,
                                                            ),
                                                        enabledBorder: OutlineInputBorder(
                                                          borderSide: const BorderSide(
                                                            color: Colors.black,
                                                            width: 1.0,
                                                          ),
                                                          borderRadius: BorderRadius.circular(24.0),
                                                        ),
                                                        focusedBorder: OutlineInputBorder(
                                                          borderSide: const BorderSide(
                                                            color: Color(0x00000000),
                                                            width: 1.0,
                                                          ),
                                                          borderRadius: BorderRadius.circular(24.0),
                                                        ),
                                                        errorBorder: OutlineInputBorder(
                                                          borderSide: BorderSide(
                                                            color: FlutterFlowTheme.of(context).error,
                                                            width: 1.0,
                                                          ),
                                                          borderRadius: BorderRadius.circular(24.0),
                                                        ),
                                                        focusedErrorBorder: OutlineInputBorder(
                                                          borderSide: BorderSide(
                                                            color: FlutterFlowTheme.of(context).error,
                                                            width: 1.0,
                                                          ),
                                                          borderRadius: BorderRadius.circular(24.0),
                                                        ),
                                                        filled: true,
                                                        fillColor: FlutterFlowTheme.of(context)
                                                            .secondaryBackground,
                                                      ),
                                                      style: FlutterFlowTheme.of(context)
                                                          .bodyMedium
                                                          .override(
                                                            fontFamily: 'Inter',
                                                            letterSpacing: 0.0,
                                                          ),
                                                      cursorColor:
                                                          FlutterFlowTheme.of(context).primaryText,
                                                      validator: _model.searchRiceTextControllerValidator
                                                          .asValidator(context),
                                                    ),
                                                  ),
                                                ),
                                              ),
                                              Expanded(
                                                child: Padding(
                                                  padding: const EdgeInsetsDirectional.fromSTEB(
                                                      20.0, 0.0, 10.0, 15.0),
                                                  child: SizedBox(
                                                    width: 200.0,
                                                    child: TextFormField(
                                                      controller: _model.searchSoupTextController,
                                                      focusNode: _model.searchSoupFocusNode,
                                                      autofocus: false,
                                                      obscureText: false,
                                                      decoration: InputDecoration(
                                                        isDense: true,
                                                        labelText: 'Soup',
                                                        labelStyle: FlutterFlowTheme.of(context)
                                                            .labelMedium
                                                            .override(
                                                              fontFamily: 'Inter',
                                                              letterSpacing: 0.0,
                                                            ),
                                                        hintText: 'Search Soup',
                                                        hintStyle: FlutterFlowTheme.of(context)
                                                            .labelMedium
                                                            .override(
                                                              fontFamily: 'Inter',
                                                              letterSpacing: 0.0,
                                                            ),
                                                        enabledBorder: OutlineInputBorder(
                                                          borderSide: const BorderSide(
                                                            color: Colors.black,
                                                            width: 1.0,
                                                          ),
                                                          borderRadius: BorderRadius.circular(24.0),
                                                        ),
                                                        focusedBorder: OutlineInputBorder(
                                                          borderSide: const BorderSide(
                                                            color: Color(0x00000000),
                                                            width: 1.0,
                                                          ),
                                                          borderRadius: BorderRadius.circular(24.0),
                                                        ),
                                                        errorBorder: OutlineInputBorder(
                                                          borderSide: BorderSide(
                                                            color: FlutterFlowTheme.of(context).error,
                                                            width: 1.0,
                                                          ),
                                                          borderRadius: BorderRadius.circular(24.0),
                                                        ),
                                                        focusedErrorBorder: OutlineInputBorder(
                                                          borderSide: BorderSide(
                                                            color: FlutterFlowTheme.of(context).error,
                                                            width: 1.0,
                                                          ),
                                                          borderRadius: BorderRadius.circular(24.0),
                                                        ),
                                                        filled: true,
                                                        fillColor: FlutterFlowTheme.of(context)
                                                            .secondaryBackground,
                                                      ),
                                                      style: FlutterFlowTheme.of(context)
                                                          .bodyMedium
                                                          .override(
                                                            fontFamily: 'Inter',
                                                            letterSpacing: 0.0,
                                                          ),
                                                      cursorColor:
                                                          FlutterFlowTheme.of(context).primaryText,
                                                      validator: _model.searchSoupTextControllerValidator
                                                          .asValidator(context),
                                                    ),
                                                  ),
                                                ),
                                              ),
                                              Expanded(
                                                child: Padding(
                                                  padding: const EdgeInsetsDirectional.fromSTEB(
                                                      20.0, 0.0, 10.0, 15.0),
                                                  child: SizedBox(
                                                    width: 200.0,
                                                    child: TextFormField(
                                                      controller: _model.searchSideDishTextController,
                                                      focusNode: _model.searchSideDishFocusNode,
                                                      autofocus: false,
                                                      obscureText: false,
                                                      decoration: InputDecoration(
                                                        isDense: true,
                                                        labelText: 'SideDish',
                                                        labelStyle: FlutterFlowTheme.of(context)
                                                            .labelMedium
                                                            .override(
                                                              fontFamily: 'Inter',
                                                              letterSpacing: 0.0,
                                                            ),
                                                        hintText: 'Search SideDish',
                                                        hintStyle: FlutterFlowTheme.of(context)
                                                            .labelMedium
                                                            .override(
                                                              fontFamily: 'Inter',
                                                              letterSpacing: 0.0,
                                                            ),
                                                        enabledBorder: OutlineInputBorder(
                                                          borderSide: const BorderSide(
                                                            color: Colors.black,
                                                            width: 1.0,
                                                          ),
                                                          borderRadius: BorderRadius.circular(24.0),
                                                        ),
                                                        focusedBorder: OutlineInputBorder(
                                                          borderSide: const BorderSide(
                                                            color: Color(0x00000000),
                                                            width: 1.0,
                                                          ),
                                                          borderRadius: BorderRadius.circular(24.0),
                                                        ),
                                                        errorBorder: OutlineInputBorder(
                                                          borderSide: BorderSide(
                                                            color: FlutterFlowTheme.of(context).error,
                                                            width: 1.0,
                                                          ),
                                                          borderRadius: BorderRadius.circular(24.0),
                                                        ),
                                                        focusedErrorBorder: OutlineInputBorder(
                                                          borderSide: BorderSide(
                                                            color: FlutterFlowTheme.of(context).error,
                                                            width: 1.0,
                                                          ),
                                                          borderRadius: BorderRadius.circular(24.0),
                                                        ),
                                                        filled: true,
                                                        fillColor: FlutterFlowTheme.of(context)
                                                            .secondaryBackground,
                                                      ),
                                                      style: FlutterFlowTheme.of(context)
                                                          .bodyMedium
                                                          .override(
                                                            fontFamily: 'Inter',
                                                            letterSpacing: 0.0,
                                                          ),
                                                      cursorColor:
                                                          FlutterFlowTheme.of(context).primaryText,
                                                      validator: _model.searchSideDishTextControllerValidator
                                                          .asValidator(context),
                                                    ),
                                                  ),
                                                ),
                                              ),
                                            ] ,
                                          ),
                                          Padding(
                                            padding: const EdgeInsetsDirectional.fromSTEB(
                                                16.0, 0.0, 16.0, 0.0),
                                            child: FFButtonWidget(
                                              text: 'Search',
                                              onPressed: () async {
                                                _model.apiResultsearch =
                                                    await SearchDietListsByOptionCall.call(
                                                  rice: _model.searchRiceTextController.text,
                                                  soup: _model.searchSoupTextController.text,
                                                  sideDish: _model.searchSideDishTextController.text
                                                );

                                                if ((_model.apiResultsearch?.succeeded ??
                                                    true)) {
                                                      FFAppState()
                                                                .DietList = [];
                                                            safeSetState(() {});
                                                      FFAppState()
                                                      .DietList = (_model
                                                              .apiResultsearch
                                                              ?.jsonBody ??
                                                          '')
                                                      .toList()
                                                      .cast<
                                                        dynamic>();
                                                        safeSetState(() {});
                                                        FFAppState().isVisibleInitButton = true;
                                                }
                                              },
                                              options: FFButtonOptions(
                                                height: 40.0,
                                                padding: const EdgeInsetsDirectional.fromSTEB(
                                                    16.0, 0.0, 16.0, 0.0),
                                                iconPadding:
                                                    const EdgeInsetsDirectional.fromSTEB(
                                                        0.0, 0.0, 0.0, 0.0),
                                                color: FlutterFlowTheme.of(context).primary,
                                                textStyle: FlutterFlowTheme.of(context)
                                                    .titleSmall
                                                    .override(
                                                      fontFamily: 'Inter Tight',
                                                      color: Colors.white,
                                                      letterSpacing: 0.0,
                                                    ),
                                                elevation: 0.0,
                                                borderRadius: BorderRadius.circular(24.0),
                                              ),
                                            ),
                                          ),
                                        ]
                                        ),
                                      );
                                    });
                              },
                              options: FFButtonOptions(
                                height: 40.0,
                                padding: const EdgeInsetsDirectional.fromSTEB(
                                    16.0, 0.0, 16.0, 0.0),
                                iconPadding:
                                    const EdgeInsetsDirectional.fromSTEB(
                                        0.0, 0.0, 0.0, 0.0),
                                color: FlutterFlowTheme.of(context).primary,
                                textStyle: FlutterFlowTheme.of(context)
                                    .titleSmall
                                    .override(
                                      fontFamily: 'Inter Tight',
                                      color: Colors.white,
                                      letterSpacing: 0.0,
                                    ),
                                elevation: 0.0,
                                borderRadius: BorderRadius.circular(24.0),
                              ),
                            ),
                          ),
                          Visibility(
                            visible: FFAppState().isVisibleInitButton,
                            child: Padding(
                              padding: const EdgeInsetsDirectional.fromSTEB(
                                  16.0, 0.0, 16.0, 0.0),
                              child: FFButtonWidget(
                                text: 'Init Diet List',
                                onPressed: () async {
                                  _model.apiResultInitList = await GetDietListCall.call();

                                  if ((_model.apiResultInitList?.succeeded ?? true)) {
                                    FFAppState().DietList =
                                        (_model.apiResultInitList?.jsonBody ?? '')
                                            .toList()
                                            .cast<dynamic>();
                                    safeSetState(() {});
                                  }
                                  FFAppState().isVisibleInitButton = false;
                                },
                                options: FFButtonOptions(
                                  height: 40.0,
                                  padding: const EdgeInsetsDirectional.fromSTEB(
                                      16.0, 0.0, 16.0, 0.0),
                                  iconPadding:
                                      const EdgeInsetsDirectional.fromSTEB(
                                          0.0, 0.0, 0.0, 0.0),
                                  color: FlutterFlowTheme.of(context).primary,
                                  textStyle: FlutterFlowTheme.of(context)
                                      .titleSmall
                                      .override(
                                        fontFamily: 'Inter Tight',
                                        color: Colors.white,
                                        letterSpacing: 0.0,
                                      ),
                                  elevation: 0.0,
                                  borderRadius: BorderRadius.circular(24.0),
                                ),
                              ),
                            ),
                          )
                        ],
                      ),
                    ),
                    Expanded(
                      child: Builder(
                        builder: (context) {
                          final left = FFAppState().DietList.toList();
                          return FlutterFlowDataTable<dynamic>(
                            controller: _model.paginatedDataTableController,
                            data: left,
                            columnsBuilder: (onSortChanged) => [
                              DataColumn2(
                                label: DefaultTextStyle.merge(
                                  softWrap: true,
                                  child: Text(
                                    'Rice',
                                    style: FlutterFlowTheme.of(context)
                                        .labelLarge
                                        .override(
                                          fontFamily: 'Inter',
                                          letterSpacing: 0.0,
                                        ),
                                  ),
                                ),
                                fixedWidth:
                                    MediaQuery.sizeOf(context).width * 0.12,
                              ),
                              DataColumn2(
                                label: DefaultTextStyle.merge(
                                  softWrap: true,
                                  child: Text(
                                    'Soup',
                                    style: FlutterFlowTheme.of(context)
                                        .labelLarge
                                        .override(
                                          fontFamily: 'Inter',
                                          letterSpacing: 0.0,
                                        ),
                                  ),
                                ),
                                fixedWidth:
                                    MediaQuery.sizeOf(context).width * 0.2,
                              ),
                              DataColumn2(
                                label: DefaultTextStyle.merge(
                                  softWrap: true,
                                  child: Text(
                                    'SideDishes',
                                    style: FlutterFlowTheme.of(context)
                                        .labelLarge
                                        .override(
                                          fontFamily: 'Inter',
                                          letterSpacing: 0.0,
                                        ),
                                  ),
                                ),
                                fixedWidth:
                                    MediaQuery.sizeOf(context).width * 0.4,
                              ),
                              DataColumn2(
                                label: DefaultTextStyle.merge(
                                  softWrap: true,
                                  child: Text(
                                    'Info',
                                    style: FlutterFlowTheme.of(context)
                                        .labelLarge
                                        .override(
                                          fontFamily: 'Inter',
                                          letterSpacing: 0.0,
                                        ),
                                  ),
                                ),
                                fixedWidth:
                                    MediaQuery.sizeOf(context).width * 0.16,
                              ),
                            ],
                            dataRowBuilder: (leftItem, leftIndex, selected,
                                    onSelectChanged) =>
                                DataRow(
                              color: MaterialStateProperty.all(
                                leftIndex % 2 == 0
                                    ? FlutterFlowTheme.of(context)
                                        .secondaryBackground
                                    : FlutterFlowTheme.of(context)
                                        .primaryBackground,
                              ),
                              cells: [
                                Text(
                                  leftItem['rice']['name'],
                                  style: FlutterFlowTheme.of(context)
                                      .bodyMedium
                                      .override(
                                        fontFamily: 'Inter',
                                        letterSpacing: 0.0,
                                      ),
                                ),
                                Text(
                                  leftItem['soup']['name'],
                                  style: FlutterFlowTheme.of(context)
                                      .bodyMedium
                                      .override(
                                        fontFamily: 'Inter',
                                        letterSpacing: 0.0,
                                      ),
                                ),
                                ListView(
                                  padding: EdgeInsets.zero,
                                  shrinkWrap: true,
                                  scrollDirection: Axis.vertical,
                                  children: List<Widget>.from(
                                    leftItem['dietSideDishList']
                                        .map((sideDish) {
                                      return Text(
                                          sideDish['sideDishDto']['name']);
                                    }),
                                  ),
                                ),
                                FFButtonWidget(
                                  onPressed: () async {
                                    FFAppState().DietId = leftItem['id'];
                                    safeSetState(() {});
                                    _model.apiResultodd =
                                        await GetDietInfoCall.call(
                                      id: FFAppState().DietId,
                                    );

                                    if ((_model.apiResultodd?.succeeded ??
                                        true)) {
                                      FFAppState().DietInfo =
                                          _model.apiResultodd?.jsonBody;
                                      context.pushNamed(
                                        'DietInfo',
                                        queryParameters: {
                                          'id': serializeParam(
                                            FFAppState().DietId,
                                            ParamType.int,
                                          ),
                                        }.withoutNulls,
                                      );
                                    }

                                    safeSetState(() {});
                                  },
                                  text: 'Info',
                                  options: FFButtonOptions(
                                    height: 40.0,
                                    padding:
                                        const EdgeInsetsDirectional.fromSTEB(
                                            16.0, 0.0, 16.0, 0.0),
                                    iconPadding:
                                        const EdgeInsetsDirectional.fromSTEB(
                                            0.0, 0.0, 0.0, 0.0),
                                    color: FlutterFlowTheme.of(context).primary,
                                    textStyle: FlutterFlowTheme.of(context)
                                        .titleSmall
                                        .override(
                                          fontFamily: 'Inter Tight',
                                          color: Colors.white,
                                          letterSpacing: 0.0,
                                        ),
                                    elevation: 0.0,
                                    borderRadius: BorderRadius.circular(8.0),
                                  ),
                                ),
                              ].map((c) => DataCell(c)).toList(),
                            ),
                            paginated: true,
                            selectable: false,
                            hidePaginator: false,
                            showFirstLastButtons: false,
                            headingRowHeight: 56.0,
                            dataRowHeight: 100.0,
                            columnSpacing: 20.0,
                            headingRowColor:
                                FlutterFlowTheme.of(context).primary,
                            borderRadius: BorderRadius.circular(8.0),
                            addHorizontalDivider: true,
                            addTopAndBottomDivider: false,
                            hideDefaultHorizontalDivider: true,
                            horizontalDividerColor: FlutterFlowTheme.of(context)
                                .secondaryBackground,
                            horizontalDividerThickness: 1.0,
                            addVerticalDivider: false,
                          );
                        },
                      ),
                    ),
                    FFButtonWidget(
                      onPressed: () async {
                        context.pushNamed('HomePage');
                      },
                      text: 'Go Back',
                      options: FFButtonOptions(
                        height: 40.0,
                        padding: const EdgeInsetsDirectional.fromSTEB(
                            16.0, 0.0, 16.0, 0.0),
                        iconPadding: const EdgeInsetsDirectional.fromSTEB(
                            0.0, 0.0, 0.0, 0.0),
                        color: FlutterFlowTheme.of(context).primary,
                        textStyle:
                            FlutterFlowTheme.of(context).titleSmall.override(
                                  fontFamily: 'Inter Tight',
                                  color: Colors.white,
                                  letterSpacing: 0.0,
                                ),
                        elevation: 0.0,
                        borderRadius: BorderRadius.circular(24.0),
                      ),
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
