import '/flutter_flow/flutter_flow_data_table.dart';
import '/flutter_flow/flutter_flow_theme.dart';
import '/flutter_flow/flutter_flow_util.dart';
import '/flutter_flow/flutter_flow_widgets.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:provider/provider.dart';
import 'diet_info_model.dart';
export 'diet_info_model.dart';

class DietInfoWidget extends StatefulWidget {
  const DietInfoWidget({
    super.key,
    required this.id,
  });

  final int? id;

  @override
  State<DietInfoWidget> createState() => _DietInfoWidgetState();
}

class _DietInfoWidgetState extends State<DietInfoWidget> {
  late DietInfoModel _model;

  final scaffoldKey = GlobalKey<ScaffoldState>();

  @override
  void initState() {
    super.initState();
    _model = createModel(context, () => DietInfoModel());
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
                      padding:
                         const EdgeInsetsDirectional.fromSTEB(0.0, 10.0, 0.0, 10.0),
                      child: Text(
                        'Nutrient Information',
                        style: FlutterFlowTheme.of(context).bodyMedium.override(
                              fontFamily: 'Inter',
                              fontSize: 28.0,
                              letterSpacing: 0.0,
                            ),
                      ),
                    ),
                    Expanded(
                      child: Builder(
                        builder: (context) {
                          final dynamic left = FFAppState().DietInfo;

                          List<dynamic> dataList = [];

                          if (left != null){
                            if (left['rice'] != null) {
                              dataList.add({
                                'name': left['rice']['name'] ?? 'Unknown Rice', // 기본값 설정
                                'calorie': left['rice']['calorie'] * 1.5 ?? 0.0,
                                'carbohydrate': left['rice']['carbohydrate'] * 1.5 ?? 0.0,
                                'protein': left['rice']['protein'] * 1.5 ?? 0.0,
                                'province': left['rice']['province'] * 1.5 ?? 0.0,
                              });
                            }

                            // Soup 정보 추가
                            if (left['soup'] != null) {
                              dataList.add({
                                'name': left['soup']['name'] ?? 'Unknown Soup', // 기본값 설정
                                'calorie': left['soup']['calorie'] * 1.5 ?? 0.0,
                                'carbohydrate': left['soup']['carbohydrate'] * 1.5 ?? 0.0,
                                'protein': left['soup']['protein'] * 1.5 ?? 0.0,
                                'province': left['soup']['province'] * 1.5 ?? 0.0,
                              });
                            }

                            // Diet Side Dish 정보 추가
                            if (left['dietSideDishList'] is List) {
                              double coef = 0.0;
                              for (var sideDish in left['dietSideDishList']!) {
                                if (sideDish['sideDishDto'] != null) {
                                  if (sideDish['sideDishDto']['classification'] == '찜류' ||
                                  sideDish['sideDishDto']['classification'] == '구이류' ||
                                  sideDish['sideDishDto']['classification'] == '전·적 및 부침류찜류'){
                                    coef = 1.0;
                                  }
                                  else{
                                    coef = 0.5;
                                  }
                                  dataList.add({
                                    'name': sideDish['sideDishDto']['name'] ?? 'Unknown Side Dish', // 기본값 설정
                                    'calorie': sideDish['sideDishDto']['calorie'] * coef ?? 0.0,
                                    'carbohydrate': sideDish['sideDishDto']['carbohydrate'] * coef ?? 0.0,
                                    'protein': sideDish['sideDishDto']['protein'] * coef ?? 0.0,
                                    'province': sideDish['sideDishDto']['province'] * coef ?? 0.0,
                                  });
                                }
                              }
                            }
                          }

                          dataList.add({
                            'name': '영양분 총 합',
                            'calorie': left['calorie'],
                            'carbohydrate': left['carbohydrate'],
                            'protein': left['protein'],
                            'province': left['province']
                          });

                          return FlutterFlowDataTable<dynamic>(
                            controller: _model.nutrientTableController,
                            data: dataList,
                            columnsBuilder: (onSortChanged) => [
                              DataColumn2(
                                label: DefaultTextStyle.merge(
                                  softWrap: true,
                                  child: Text(
                                    'Name',
                                    style: FlutterFlowTheme.of(context)
                                        .labelLarge
                                        .override(
                                          fontFamily: 'Inter',
                                          letterSpacing: 0.0,
                                        ),
                                  ),
                                ),
                              ),
                              DataColumn2(
                                label: DefaultTextStyle.merge(
                                  softWrap: true,
                                  child: Text(
                                    'Calorie',
                                    style: FlutterFlowTheme.of(context)
                                        .labelLarge
                                        .override(
                                          fontFamily: 'Inter',
                                          letterSpacing: 0.0,
                                        ),
                                  ),
                                ),
                              ),
                              DataColumn2(
                                label: DefaultTextStyle.merge(
                                  softWrap: true,
                                  child: Text(
                                    'Carbohydrate',
                                    style: FlutterFlowTheme.of(context)
                                        .labelLarge
                                        .override(
                                          fontFamily: 'Inter',
                                          letterSpacing: 0.0,
                                        ),
                                  ),
                                ),
                              ),
                              DataColumn2(
                                label: DefaultTextStyle.merge(
                                  softWrap: true,
                                  child: Text(
                                    'Protein',
                                    style: FlutterFlowTheme.of(context)
                                        .labelLarge
                                        .override(
                                          fontFamily: 'Inter',
                                          letterSpacing: 0.0,
                                        ),
                                  ),
                                ),
                              ),
                              DataColumn2(
                                label: DefaultTextStyle.merge(
                                  softWrap: true,
                                  child: Text(
                                    'Province',
                                    style: FlutterFlowTheme.of(context)
                                        .labelLarge
                                        .override(
                                          fontFamily: 'Inter',
                                          letterSpacing: 0.0,
                                        ),
                                  ),
                                ),
                              ),
                            ],
                            dataRowBuilder: (leftItem, leftIndex, selected,
                                    onSelectChanged) {
                                    print('Row $leftIndex: $leftItem');
                                return DataRow(
                              color: MaterialStateProperty.all(
                                leftIndex % 2 == 0
                                    ? FlutterFlowTheme.of(context).secondaryBackground
                                    : FlutterFlowTheme.of(context).primaryBackground,
                              ),
                              cells: [
                                DataCell(
                                  Text(
                                    leftItem['name'],
                                    style: FlutterFlowTheme.of(context).bodyMedium.override(
                                          fontFamily: 'Inter',
                                          letterSpacing: 0.0,
                                        ),
                                  ),
                                ),
                                DataCell(
                                  Text(
                                    '${leftItem['calorie'].toStringAsFixed(1)}kcal', 
                                    style: FlutterFlowTheme.of(context).bodyMedium.override(
                                          fontFamily: 'Inter',
                                          letterSpacing: 0.0,
                                        ),
                                  ),
                                ),
                                DataCell(
                                  Text(
                                    '${leftItem['carbohydrate'].toStringAsFixed(1)}g',
                                    style: FlutterFlowTheme.of(context).bodyMedium.override(
                                          fontFamily: 'Inter',
                                          letterSpacing: 0.0,
                                        ),
                                  ),
                                ),
                                DataCell(
                                  Text(
                                    '${leftItem['protein'].toStringAsFixed(1)}g', // 밥 칼로리
                                    style: FlutterFlowTheme.of(context).bodyMedium.override(
                                          fontFamily: 'Inter',
                                          letterSpacing: 0.0,
                                        ),
                                  ),
                                ),
                                DataCell(
                                  Text(
                                    '${leftItem['province'].toStringAsFixed(1)}g', // 밥 칼로리
                                    style: FlutterFlowTheme.of(context).bodyMedium.override(
                                          fontFamily: 'Inter',
                                          letterSpacing: 0.0,
                                        ),
                                  ),
                                ),
                              ],
                              );
                            },
                            paginated: false,
                            selectable: false,
                            width: MediaQuery.sizeOf(context).width * 1.0,
                            height: MediaQuery.sizeOf(context).height * 0.6,
                            minWidth: MediaQuery.sizeOf(context).width * 0.7,
                            headingRowHeight: 56.0,
                            dataRowHeight: 48.0,
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
                    Padding(
                      padding:
                          const EdgeInsetsDirectional.fromSTEB(0.0, 10.0, 0.0, 0.0),
                      child: FFButtonWidget(
                        onPressed: () async {
                          context.pushNamed('DietList');
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
